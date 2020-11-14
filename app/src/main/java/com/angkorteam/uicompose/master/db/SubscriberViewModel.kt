package com.example.myhello.db

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val inputName = MutableLiveData<String>()

    val inputEmail = MutableLiveData<String>()

}