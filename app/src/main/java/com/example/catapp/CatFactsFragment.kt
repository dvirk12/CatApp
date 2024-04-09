package com.example.catapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.catapp.ui.CatViewModel

class CatFactsFragment : Fragment() {

    private val catViewModel: CatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat_facts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the LiveData from the ViewModel.
        catViewModel.catFacts.observe(viewLifecycleOwner, Observer { catFacts ->
            // Assuming your list of cat facts is not empty, take the first one to display.
            val catFact = catFacts.firstOrNull() ?: return@Observer

            // Set the cat image
            view.findViewById<ImageView>(R.id.catImageView)?.let { imageView ->
                Glide.with(this).load(catFact.url).into(imageView)
            }

            catFact.breeds?.firstOrNull()?.let { breed ->
                view.findViewById<TextView>(R.id.catNameTextView)?.text = breed.name ?: "Unknown"
                view.findViewById<TextView>(R.id.catTemperamentTextView)?.text = breed.temperament ?: "Unknown"
                view.findViewById<TextView>(R.id.catOriginTextView)?.text = breed.origin ?: "Unknown"
            } ?: run {
                // Handle the case where breeds is null or empty
                view.findViewById<TextView>(R.id.catNameTextView)?.text = "Unknown"
                view.findViewById<TextView>(R.id.catTemperamentTextView)?.text = "Unknown"
                view.findViewById<TextView>(R.id.catOriginTextView)?.text = "Unknown"
            }

        })
    }
}
