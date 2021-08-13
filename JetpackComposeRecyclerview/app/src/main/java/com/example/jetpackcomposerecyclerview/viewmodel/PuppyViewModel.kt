package com.example.jetpackcomposerecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposerecyclerview.PuppyData
import com.example.jetpackcomposerecyclerview.R

class PuppyViewModel: ViewModel() {

    val puppysList: MutableLiveData<List<PuppyData>> by lazy {
        MutableLiveData<List<PuppyData>>()
    }

    private var puppyList: ArrayList<PuppyData>
    init {
        puppyList = ArrayList()
        getPuppyLists()
    }

    private fun getPuppyLists(){
        fetchList()
        puppysList.value = puppyList
    }

    private fun fetchList(){
        puppyList.add(PuppyData(R.drawable.bears,"Bear","Aloof,Loyal,Independent,Quiet"))
        puppyList.add(PuppyData(R.drawable.coorep,"Cooper","Steady,Bold,Independent,Confident,Intelligent,Proud"))
        puppyList.add(PuppyData(R.drawable.emersons,"Emerson","Spirited,Alert,Loyal,Companionable,Even,Tempered,Courageous"))
        puppyList.add(PuppyData(R.drawable.puppys,"Puppy","Feisty,Affectionate,Cheerful,Playful,Gentle,Sensitive"))
        puppyList.add(PuppyData(R.drawable.hudsons,"Hudson","Strong willed Stubborn,Friendly,Intelligent,Courageous,Affectionate"))
        puppyList.add(PuppyData(R.drawable.jikcs,"Jack","Kind,Sweet-Tempered,Loving,Loyal,Intelligent,Independent"))
        puppyList.add(PuppyData(R.drawable.kais,"Kai","Protective,Loyal,Gentle,Rational,Familial,Intelligent"))
        puppyList.add(PuppyData(R.drawable.maxs,"Max","Docile,Reliable,Devoted,Alert,Reserved,Calm,Courageous,Powerful"))
        puppyList.add(PuppyData(R.drawable.puppys,"Puppy","Feisty,Affectionate,Cheerful,Playful,Gentle,Sensitive"))
        puppyList.add(PuppyData(R.drawable.surreys,"Sawyer","Trainable,Playful,Friendly,Faithful,Affectionate"))
        puppyList.add(PuppyData(R.drawable.bears,"Bear","Aloof,Loyal,Independent,Quiet"))
        puppyList.add(PuppyData(R.drawable.coorep,"Cooper","Steady,Bold,Independent,Confident,Intelligent,Proud"))
        puppyList.add(PuppyData(R.drawable.finns,"Finn","Playful,Loyal,Intelligent,Vocal,Happy"))
    }

}