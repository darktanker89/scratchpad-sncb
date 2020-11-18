package be.johnkichi.sampleapp.api.rail.models.request

import com.squareup.moshi.ToJson

enum class FieldOccupancy(val value: String) {
    LOW("http://api.irail.be/terms/low"),
    MEDIUM("http://api.irail.be/terms/medium"),
    HIGH("http://api.irail.be/terms/high")
}

class FieldOccupancyAdapter {
    @ToJson
    fun toJson(occupancy: FieldOccupancy): String = occupancy.value
}
