package com.example.homework11_leacture14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework11_leacture14.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity(),OnItemClickListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var myAdaper: PictureItemForRecyclerAdapter
    private var animalList = mutableListOf<Animal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUp()
    }

    private fun setUp(){

        animalList = mutableListOf<Animal>(
            Animal(0,R.drawable.dog3,"Herz","description1",Kingdome.DOG,1),
            Animal(1,R.drawable.racoon1,"Bob","Don't move Don't move ,Let me see your hands",Kingdome.RACOON,1),
            Animal(2,R.drawable.squirl1,"Mark","Acrobatic",Kingdome.SQUIRRLE,1),
            Animal(3,R.drawable.dog2,"Hachi","description1",Kingdome.DOG,1),
            Animal(4,R.drawable.dog1,"Rocky","Good Boy",Kingdome.DOG,1),
            Animal(5,R.drawable.dog4,"Brown","Good Boy",Kingdome.DOG,1),
            Animal(6,R.drawable.dog5,"Pup","Good Girl",Kingdome.DOG,1),
            Animal(7,R.drawable.dog7,"Englishmen","Good And Lazy Boy",Kingdome.DOG,1),
            Animal(8,R.drawable.racoon2,"Bob","Don't move Don't move ,Let me see your nose",Kingdome.RACOON,1),
            Animal(9,R.drawable.racoon3,"Bob","Party Animal",Kingdome.RACOON,1),
            Animal(10,R.drawable.squirl2,"Mark's Cousin","Acrobatic",Kingdome.SQUIRRLE,1),
            Animal(11,R.drawable.squirl3,"Mark's Cousin","Acrobatic",Kingdome.SQUIRRLE,1),
            Animal(12,R.drawable.cat2,"Rijika","Lion but smaller",Kingdome.CAT,1),
            Animal(13,R.drawable.cat1,"Ruxo","Panther but smaller",Kingdome.CAT,1),
            Animal(14,R.drawable.cat3,"Ariel","Albinos Panther but smaller",Kingdome.CAT,1),
            Animal(15,R.drawable.cat4,"Tarsa","Tarsia",Kingdome.CAT,1)
        )

        myAdaper = PictureItemForRecyclerAdapter(this)
        bindings(animalList)
    }

    private fun bindings(animalList: MutableList<Animal>){
        binding.apply {
            recycler1.apply{
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@MainActivity, 3)
                adapter = myAdaper
                myAdaper.submitList(animalList)
            }

            edtTxt1.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    filterList(s.toString())
                }
            })
        }
    }

    private fun submitFilteredList(animalList: MutableList<Animal>){
        myAdaper.submitList(animalList)
    }

    override fun onItemClick(animal: Animal) {
        val fragment = AnimalFragment.newInstance(animal)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun filterList(query: String) {
        val filteredList = if (query.isEmpty()) {
            animalList
        } else {
            animalList.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.animalType.name.contains(query, ignoreCase = true)
            }
        }
        Log.d("tag123","${filteredList.toString()}")
        myAdaper.submitList(filteredList)
    }
}
