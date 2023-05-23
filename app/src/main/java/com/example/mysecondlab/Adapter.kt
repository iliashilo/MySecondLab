package com.example.mysecondlab


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adapter(
    private val fragment: FirstFragment,
    private val animalList: ArrayList<AnimalDC>,
    private val listener: Listener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Оголошуємо змінні та знаходимо їх на фрагменті
        val imageView: ImageView = itemView.findViewById(R.id.tv_image)
        val textViewName: TextView = itemView.findViewById(R.id.tv_name)
        val textViewDescShort: TextView = itemView.findViewById(R.id.tv_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cards_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animalList[position]
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }

        // Відображення зображень на картці
        Glide.with(fragment)
            .load(animalList[position].url).fitCenter().into(holder.imageView)

        // Відображення імені на картці
        holder.textViewName.text = animal.name

        // Відображення виду на картці
        holder.textViewDescShort.text = animal.kindOfAnimal


    }

    interface Listener {
        fun onClick(itemView: Int)
    }


}