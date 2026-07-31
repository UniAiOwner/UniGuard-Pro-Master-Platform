CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE tenants (
    tenant_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    organization_name VARCHAR(120) NOT NULL,
    tenant_type VARCHAR(30) NOT NULL CHECK (tenant_type IN ('SUPERADMIN', 'WHOLESALER_DISTRIBUTOR', 'NBFC_PARTNER')),
    primary_contact_name VARCHAR(100) NOT NULL,
    primary_email VARCHAR(120) UNIQUE NOT NULL,
    primary_phone VARCHAR(20) UNIQUE NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE distributors (
    distributor_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tenant_id UUID NOT NULL REFERENCES tenants(tenant_id) ON DELETE CASCADE,
    business_name VARCHAR(120) NOT NULL,
    gstin VARCHAR(15) UNIQUE,
    assigned_region VARCHAR(100) NOT NULL,
    credit_limit_amount DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    outstanding_balance DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    wholesale_key_price DECIMAL(8, 2) NOT NULL DEFAULT 70.00,
    is_suspended BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE retailers (
    retailer_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    distributor_id UUID NOT NULL REFERENCES distributors(distributor_id) ON DELETE RESTRICT,
    shop_name VARCHAR(120) NOT NULL,
    owner_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) UNIQUE NOT NULL,
    gstin VARCHAR(15),
    address_line TEXT NOT NULL,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    credit_limit_amount DECIMAL(12, 2) NOT NULL DEFAULT 25000.00,
    outstanding_balance DECIMAL(12, 2) NOT NULL DEFAULT 0.00,
    pricing_tier VARCHAR(30) NOT NULL DEFAULT 'STANDARD',
    is_suspended BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE license_keys (
    key_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    key_code VARCHAR(30) UNIQUE NOT NULL,
    batch_id VARCHAR(50) NOT NULL,
    minted_by_tenant_id UUID NOT NULL REFERENCES tenants(tenant_id),
    current_owner_distributor_id UUID REFERENCES distributors(distributor_id),
    current_owner_retailer_id UUID REFERENCES retailers(retailer_id),
    status VARCHAR(30) NOT NULL DEFAULT 'MINTED' CHECK (status IN ('MINTED', 'TRANSFERRED', 'RETAILER_STOCK', 'CONSUMED', 'REVOKED')),
    hmac_signature VARCHAR(64) NOT NULL,
    consumed_at TIMESTAMPTZ,
    consumed_by_device_id UUID,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_license_keys_status ON license_keys(status);
CREATE INDEX idx_license_keys_retailer ON license_keys(current_owner_retailer_id) WHERE status = 'RETAILER_STOCK';

CREATE TABLE finance_cases (
    case_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    retailer_id UUID NOT NULL REFERENCES retailers(retailer_id),
    license_key_id UUID UNIQUE NOT NULL REFERENCES license_keys(key_id),
    customer_name VARCHAR(100) NOT NULL,
    customer_mobile VARCHAR(20) NOT NULL,
    customer_aadhaar_hash VARCHAR(64),
    device_make VARCHAR(50) NOT NULL,
    device_model VARCHAR(50) NOT NULL,
    primary_imei VARCHAR(20) UNIQUE NOT NULL,
    secondary_imei VARCHAR(20),
    serial_number VARCHAR(50),
    total_financed_amount DECIMAL(10, 2) NOT NULL,
    downpayment_amount DECIMAL(10, 2) NOT NULL,
    emi_amount DECIMAL(10, 2) NOT NULL,
    total_tenure_months INT NOT NULL,
    completed_tenure_months INT NOT NULL DEFAULT 0,
    next_due_date DATE NOT NULL,
    case_status VARCHAR(30) NOT NULL DEFAULT 'ACTIVE' CHECK (case_status IN ('ACTIVE', 'LOCKED', 'PAID_OFF', 'DEFAULTED', 'LEGAL_FREEZE')),
    current_lock_state VARCHAR(30) NOT NULL DEFAULT 'UNLOCKED' CHECK (current_lock_state IN ('UNLOCKED', 'REMINDER_PAYLOAD', 'RESTRICTED_APPS', 'LOCKED_KIOSK')),
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_finance_cases_imei ON finance_cases(primary_imei);
CREATE INDEX idx_finance_cases_status ON finance_cases(case_status, next_due_date);

CREATE TABLE timeline_events (
    event_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    case_id UUID NOT NULL REFERENCES finance_cases(case_id) ON DELETE CASCADE,
    event_type VARCHAR(50) NOT NULL,
    actor_type VARCHAR(30) NOT NULL,
    actor_id VARCHAR(50) NOT NULL,
    event_payload JSONB NOT NULL,
    recorded_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_timeline_events_case ON timeline_events(case_id, recorded_at DESC);

CREATE TABLE audit_logs (
    audit_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tenant_id UUID REFERENCES tenants(tenant_id),
    user_id VARCHAR(50) NOT NULL,
    action VARCHAR(100) NOT NULL,
    resource_target VARCHAR(100) NOT NULL,
    ip_address VARCHAR(45) NOT NULL,
    user_agent TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE finance_cases ENABLE ROW LEVEL SECURITY;
ALTER TABLE license_keys ENABLE ROW LEVEL SECURITY;

CREATE POLICY retailer_cases_isolation ON finance_cases
    FOR ALL TO PUBLIC
    USING (retailer_id = NULLIF(current_setting('app.current_retailer_id', true), '')::UUID);
