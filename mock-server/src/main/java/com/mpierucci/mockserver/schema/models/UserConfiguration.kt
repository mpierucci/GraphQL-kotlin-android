package com.mpierucci.mockserver.schema.models

data class UserConfiguration(
    val forceUpdate: Boolean = false,
    val isApproved: Boolean = true,
    val statusPollInterval: Int = 5,
    val decommissionFlow: Boolean = false
)
