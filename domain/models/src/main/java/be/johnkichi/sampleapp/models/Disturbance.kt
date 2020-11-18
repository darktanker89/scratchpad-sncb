package be.johnkichi.sampleapp.models

interface Disturbance {
    val attachment: String? // pdf
    val description: String //
    val id: String
    val link: String // web page
    val timestamp: String // in sec
    val title: String //
    val type: String //
}
