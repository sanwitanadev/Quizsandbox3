/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.quizsandbox3.data

import androidx.annotation.StringRes
import com.example.quizsandbox3.R

/**
 * A data class to represent the information presented in the dog card
 */
data class Calon(
    @StringRes val nama: Int,
    val umur: Int,
    val alamat: Int,
    @StringRes val des: Int
)

val calons = listOf(
    Calon(R.string.nama1, 18, R.string.alamat1, R.string.des1),
    Calon(R.string.nama2, 21, R.string.alamat2, R.string.des2),
    Calon(R.string.nama3, 19, R.string.alamat3, R.string.des3),
    Calon(R.string.nama4, 25, R.string.alamat4, R.string.des4),
    Calon(R.string.nama5, 27, R.string.alamat5, R.string.des5),
    Calon(R.string.nama6, 19, R.string.alamat6, R.string.des6),
    Calon(R.string.nama7, 25, R.string.alamat7, R.string.des7),
)
