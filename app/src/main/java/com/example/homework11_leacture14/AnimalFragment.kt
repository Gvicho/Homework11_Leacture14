package com.example.homework11_leacture14

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework11_leacture14.databinding.FragmentAnimalBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimalFragment() : Fragment() {
    lateinit var binding: FragmentAnimalBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val data = it.getString("animal")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimalBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animal = arguments?.getSerializable(ARG_ANIMAL) as? Animal
        Log.d("tag123", "OnViewCreated ${animal?.name}")

        animal?.let {
            Log.d("tag123", "Onbinding")
            binding.imageAnimal.setImageResource(animal.imige)
            binding.nameTxt1.text = animal.name
            binding.nameTxt2.text = animal.description
        }
    }

    companion object {
        private const val ARG_ANIMAL = "animal"

        @JvmStatic
        fun newInstance(animal: Animal): AnimalFragment {
            val fragment = AnimalFragment()
            val args = Bundle()
            args.putSerializable(ARG_ANIMAL, animal)
            fragment.arguments = args
            Log.d("tag123","newInstance ${animal.name}")
            return fragment
        }
    }
}