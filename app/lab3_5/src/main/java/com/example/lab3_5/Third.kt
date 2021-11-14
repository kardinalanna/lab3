package com.example.lab3_5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class Third : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<Button>(R.id.btn_a3_to_a2)?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_Third_to_Second)
        }

        view?.findViewById<Button>(R.id.btn_a3_to_a1)?.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_Third_to_First)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(item.itemId == R.id.about ) {
            (activity as MainActivity).navController.navigate(R.id.action_Third_to_activityAbout)
            true
        }
        else return super.onOptionsItemSelected(item)
    }
}