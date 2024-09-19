package com.shesound.sapppowertools.domain.repository

interface ServiceRepository {
    fun isNetworkConnected(): Boolean
}