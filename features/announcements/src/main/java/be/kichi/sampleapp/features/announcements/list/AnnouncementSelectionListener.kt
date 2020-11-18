package be.kichi.sampleapp.features.announcements.list

import be.johnkichi.sampleapp.models.Disturbance

interface AnnouncementSelectionListener {
    fun onAnnouncementClicked(disturbance: Disturbance)
}
