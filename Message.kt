package com.acrossdeiiglobe.selfpromo

import android.icu.text.CaseMap.Title
import java.io.Serializable
import java.sql.Date

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val startDate: String?
) : Serializable {

    fun getFullJobDescription() = if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"

    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"

}
