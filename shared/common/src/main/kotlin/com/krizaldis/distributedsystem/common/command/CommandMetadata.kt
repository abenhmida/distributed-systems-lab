package com.krizaldis.distributedsystem.common.command

import com.krizaldis.distributedsystem.common.messaging.CausationId
import com.krizaldis.distributedsystem.common.messaging.CorrelationId
import com.krizaldis.distributedsystem.common.messaging.TenantId
import com.krizaldis.distributedsystem.common.messaging.TraceId

data class CommandMetadata(
    val correlationId: CorrelationId,
    val causationId: CausationId?,
    val traceId: TraceId?,
    val tenantId: TenantId?
)