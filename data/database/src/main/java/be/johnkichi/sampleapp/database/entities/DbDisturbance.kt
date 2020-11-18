package be.johnkichi.sampleapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import be.johnkichi.sampleapp.models.Disturbance

@Entity
data class DbDisturbance(
    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: String,
    @ColumnInfo(name = "attachment")
    override val attachment: String?,
    @ColumnInfo(name = "description")
    override val description: String,
    @ColumnInfo(name = "link")
    override val link: String,
    @ColumnInfo(name = "timestamp")
    override val timestamp: String,
    @ColumnInfo(name = "title")
    override val title: String,
    @ColumnInfo(name = "type")
    override val type: String
) : Disturbance
