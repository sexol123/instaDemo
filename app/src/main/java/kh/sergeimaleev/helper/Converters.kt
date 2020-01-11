package kh.sergeimaleev.helper

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*

const val FORMATTED_PATTERN = "E, dd MMM yyyy HH:mm:ss"

object Converters {
    @JvmStatic
    @BindingConversion
    fun toFormattedString(date: Long?): String {
        return if (date == null) ""
        else SimpleDateFormat(FORMATTED_PATTERN, Locale.ENGLISH).format(Date(date))
    }

    @JvmStatic
    @BindingConversion
    fun toClearString(s: List<String>): String {
        val sb = StringBuilder()
        s.forEach {
            sb.append(it)
            sb.append(" ")
        }
        return sb.trim().toString()
    }
}