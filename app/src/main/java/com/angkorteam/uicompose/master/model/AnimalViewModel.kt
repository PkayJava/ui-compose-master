package com.angkorteam.uicompose.master.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay

class AnimalViewModel : ViewModel() {

    private var nextPage = 0

    fun getMaster(): LiveData<List<Animal>> = liveData {
        var first = listOf(
            Animal(1, "🐶", "Dog"),
            Animal(2, "🐱", "Cat"),
            Animal(3, "🐭", "Mouse"),
            Animal(4, "🐹", "Hamster"),
            Animal(5, "🐰", "Rabbit"),
            Animal(6, "🦊", "Fox"),
            Animal(7, "🐻", "Bear"),
            Animal(8, "🐼", "Panda"),
            Animal(9, "🐻‍❄️", "Polar Bear"),
            Animal(10, "🐨", "Koala"),
            Animal(11, "🐯", "Tiger"),
            Animal(12, "🦁", "Lion"),
            Animal(13, "🐮", "Cow"),
            Animal(14, "🐷", "Pig"),
            Animal(15, "🐸", "Frog")
        )
        emit(first)
    }

    suspend fun loadMoreAnimal(livedata: MutableLiveData<List<Animal>>) {
        Log.i("NextPage", nextPage.toString())
        delay(2000)
        var currentList = livedata.value?.toMutableList() ?: mutableListOf()
        currentList.addAll(
            listOf(
                Animal(16, "🐵", "Monkey"),
                Animal(17, "🐔", "Chicken"),
                Animal(18, "🐧", "Penguin"),
                Animal(19, "🐦", "Bird"),
                Animal(20, "🐤", "Chick"),
                Animal(21, "🦆", "Duck"),
                Animal(22, "🦅", "Eagle"),
                Animal(23, "🦉", "Owl"),
                Animal(24, "🦇", "Bat"),
                Animal(25, "🐺", "Wolf"),
                Animal(26, "🐗", "Boar"),
                Animal(27, "🐴", "Horse"),
                Animal(28, "🦄", "Unicorn"),
                Animal(29, "🐝", "Bee"),
                Animal(30, "🐛", "Bug")
            )
        )

        livedata.postValue(currentList)
        nextPage++
    }

}