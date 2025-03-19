package com.test.bikemapapplication.data

data class ApiResponse<T>(val result: T?, val error: Error?)
