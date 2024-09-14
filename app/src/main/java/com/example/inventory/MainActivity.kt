/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.inventory.ui.theme.InventoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            InventoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InventoryApp()
                }
            }
        }
    }
}

/**
 * Esse método é chamado quando a atividade é criada. Aqui, ele configura o layout da atividade e define o conteúdo.
 * enableEdgeToEdge(): Habilita o modo edge-to-edge, que permite que o conteúdo da atividade se estenda até as bordas da tela.
 * setContent: Define o conteúdo da atividade usando um bloco de código Jetpack Compose.
 * InventoryTheme: Aplica o tema definido no seu aplicativo. Dentro desse bloco, você define a aparência geral da interface do usuário.
 * Surface: Um contêiner para a superfície do layout que usa a cor de fundo do tema.
 * InventoryApp(): Chama um composable que provavelmente define a interface principal do aplicativo.
 */