package com.example.animallist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Animal(val name : String , val type : String, val imagID: Int)

class MainActivity : AppCompatActivity() {

    lateinit var  recyclerView: RecyclerView
    val animalList = mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rView)

        animalList.add(Animal("Cow","Domestic",R.drawable.cow))
        animalList.add(Animal("Sparrow","Bird",R.drawable.sparrow))
        animalList.add(Animal("Eagle","Bird",R.drawable.eagle))
        animalList.add(Animal("Beaver","Wild",R.drawable.beaver))

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = GridLayoutManager(this , 2)

        recyclerView.adapter = AnimalAdapter(animalList, ::onAnimalSelected)

    }

    private fun onAnimalSelected(animal : Animal) {
        Toast.makeText(this," ${animal.name}, It is a ${animal.type} type animal",
            Toast.LENGTH_SHORT).show()
    }
}


//Animals list - Grid (2 columns)
//
//
//
//ImageView
//Name -
//Type - Bird/domestic/wild



//AnimalForKids
//
//
//
//- Activity
//- Fragment
//- RadioButtons
//- Wild
//- Domestic
//- Birds
//
//
//
//- Fragment
//- RecyclerView - List of Animals as per type selected