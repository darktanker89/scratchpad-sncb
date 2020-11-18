package be.kichi.sampleapp.features.announcements

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar

@SuppressLint("SimpleDateFormat")
fun formatDate(milli: Long, dateFormat: String = "dd/MM/yyyy hh:mm:ss"): String {
    val formatter = SimpleDateFormat(dateFormat)
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = milli
    return formatter.format(calendar.time)
}
