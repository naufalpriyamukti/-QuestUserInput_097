package com.example.tugas5

import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugas5.ui.theme.Tugas5Theme

@Composable
fun FormDataDiri(){
    //Variabel-varibel untuk mengingat nilai masukan dari keyboard
    var textNama by remerber { mutableStateOf(value = " ") }
    var textAlamat by remerber { mutableStateOf(value = " ") }
    var textJK by remerber { mutableStateOf(value = " ") }

    //Variabel-varibel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remerber { mutableStateOf(value = " ") }
    var alamat by remerber { mutableStateOf(value = " ") }
    var jenis by remerber { mutableStateOf(value = " ") }

    val gender:List<String> = listOf("Laki-laki", "Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArragement = Arrangement.Top,
        horizontalAlignment = Allingnment.CenterHorizontally){
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width=250.dp),
            label = {Text{text = "Nama Lengkap"}},
            onValueChange = {
                textNama = it
            }
        )
        Row {
            gender.forEach { item ->
                Row (modifier = Modifier.selectable(
                    selected = textJk == item,
                    onClick = { textJk = item}
                ), verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textJk == item,
                        onClick = {
                            textJk = item
                        })
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = {Text(text = "Alamat Lengkap")},
            onValueChange = {
                textAlamat = it
            }
        )

        Divider(
            modifier = Modifier.padding(bottom = dimensionResource(id=R.dimen.padding_medium), top = dimensionResource(
                id = R.dimen.padding_medium
            )),
            thickness = dimensionResource(id=R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            // the button is enabled when the user makes a selection
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama=textNama
                jenis=textJK
                alamat=textAlamat
            }
        ) {

        }
    }

}