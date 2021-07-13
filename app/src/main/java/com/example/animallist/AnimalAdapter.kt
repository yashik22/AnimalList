package com.example.animallist


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(val dataSet : List<Animal>, val listener : (Animal) -> Unit ) : RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {
    class AnimalHolder(view : View) : RecyclerView.ViewHolder(view) {

        val imgView : ImageView = view.findViewById(R.id.iv)
        val nameTextView :TextView = view.findViewById(R.id.animalnameT)
        val typeTextView : TextView = view.findViewById(R.id.animaltypeT)
        val cardView : CardView = view.findViewById(R.id.cView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.animal_list_item,parent,false)
        return AnimalHolder(v)

    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        val animal = dataSet[position]
        holder.imgView.setImageResource(animal.imagID)
        holder.nameTextView.text = animal.name
        holder.typeTextView.text = animal.type



        when(animal.type){
            "Wild" ->{
                holder.cardView.setCardBackgroundColor(Color.GREEN)
            }
            "Domestic" ->{
                holder.cardView.setCardBackgroundColor(Color.LTGRAY)
            }
            "Bird" ->{
                holder.cardView.setCardBackgroundColor(Color.BLUE)
            }
        }
        val animalAnim = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.anim_animal)
        holder.itemView.startAnimation(animalAnim)

        holder.itemView.setOnClickListener {
            listener(animal)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}