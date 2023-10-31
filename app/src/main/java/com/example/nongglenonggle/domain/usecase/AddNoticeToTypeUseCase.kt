package com.example.nongglenonggle.domain.usecase

import com.example.nongglenonggle.domain.repository.FirestoreSetRepository
import com.google.firebase.firestore.DocumentReference
import javax.inject.Inject

class AddNoticeToTypeUseCase @Inject constructor(private val firestoreSetRepository: FirestoreSetRepository) {
    suspend operator fun invoke(docRef:DocumentReference,id:String){
        return firestoreSetRepository.addNoticeToType(docRef, id)
    }
}