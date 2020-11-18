package be.johnkichi.sampleapp.database.converter

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimeStamp(date: Date?): Long? {
        return date?.time
    }

    // List<String> Converter
    @TypeConverter
    fun stringToListOfString(value: String?): List<String>? {
        return value?.split(",") ?: emptyList()
    }

    @TypeConverter
    fun listOfStringToString(value: List<String>?): String {
        return value?.joinToString(separator = ",") ?: ""
    }

    // List<Int> Converter for IDs
    @TypeConverter
    fun stringToListOfInt(value: String?): List<Int>? {
        val list = mutableListOf<Int>()
        value.takeIf { !it.isNullOrBlank() }
            ?.split(",")
            ?.map { id: String ->
                list.add(id.toInt())
            }
        return list
    }

    @TypeConverter
    fun listOfIntToString(value: List<Int>?): String? {
        return value?.joinToString(separator = ",")
    }
}
