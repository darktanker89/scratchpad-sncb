package be.kichi.sampleapp.features.announcements.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import be.johnkichi.sampleapp.models.Disturbance
import be.kichi.sampleapp.features.announcements.R
import be.kichi.sampleapp.features.announcements.databinding.CellDisturbanceBinding
import be.kichi.sampleapp.features.announcements.formatDate
import be.kichi.sampleapp.features.announcements.list.AnnouncementSelectionListener

class DisturbanceAdapter(
    private val announcementSelectionListener: AnnouncementSelectionListener
) : RecyclerView.Adapter<DisturbanceAdapter.DisturbanceViewHolder>() {

    private var disturbances = listOf<Disturbance>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisturbanceViewHolder {
        Log.d("FGV", "creating a new viewholder")
        val inflater = LayoutInflater.from(parent.context)
        val binding = CellDisturbanceBinding.inflate(inflater, parent, false)
        return DisturbanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DisturbanceViewHolder, position: Int) {
        Log.d("FGV", "dispatching a bind")
        holder.bind(disturbances[position], announcementSelectionListener)
    }

    override fun getItemCount(): Int = disturbances.size

    fun setData(data: List<Disturbance>) {
        // diff util here
        Log.d("FGV", "setting new data")
        disturbances = data
        notifyDataSetChanged()
    }

    class DisturbanceViewHolder(private val binding: CellDisturbanceBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(item: Disturbance, clickListener: AnnouncementSelectionListener) {
            binding.title.text = item.title
            binding.timestamp.text = formatDate(item.timestamp.toLong() * 1_000)
            binding.description.text = item.description
            binding.type.text = item.type
            when (item.type) {
                "planned" -> {
                    binding.type.setTextColor(
                        ContextCompat.getColor(binding.type.context, R.color.teal_200)
                    )
                }
                "disturbance" -> {
                    binding.type.setTextColor(ContextCompat.getColor(binding.type.context, R.color.colorError))
                }
                else -> binding.type.setTextColor(ContextCompat.getColor(binding.type.context, R.color.black))
            }
            binding.disturbanceLayout.setOnClickListener {
                clickListener.onAnnouncementClicked(item)
            }
        }
    }
}
