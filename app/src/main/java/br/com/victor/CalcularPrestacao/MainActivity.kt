package br.com.victor.CalcularPrestacao

import android.os.Bundle
import android.renderscript.Sampler.Value
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.victor.CalcularPrestacao.ui.theme.CalcularPrestacaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalcularPrestacaoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color =  MaterialTheme.colorScheme.background
                ) {
                        App()

                }

                }
            }
        }
    }


@Composable
fun App() {

    var valorBem by remember { mutableStateOf("") }
    var quantMeses by remember { mutableStateOf("") }
    var taxaAdm by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }



    Column(Modifier.background(color = Color(0xFF00BCDF4))
        .fillMaxSize(),
    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Calc Consórcio",
            style = TextStyle(
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.size(30.dp))

        Text(text = "Qual o valor da minha parcela?",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )


        Spacer(modifier = Modifier.size(30.dp))
        Text(text = "Valor do Bem (R$)")
        TextField(
            value = valorBem,
            onValueChange = { novoValor ->
                valorBem = novoValor
            },
            label =   {
                Text(text = "Valor do Bem")
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Quantidade de Meses")
        TextField(
            value = quantMeses,
            onValueChange = { novoMeses ->
                quantMeses = novoMeses
            },
            label =   {
                Text(text = "Meses")
            }
        )

        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Taxa de Admininstração em %")
        TextField(
            value = taxaAdm,
            onValueChange = { NovoFundoReserva ->
                taxaAdm = NovoFundoReserva
            },
            label =   {
                Text(text = "Taxa adm em %")
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Parcela Estimada Mensal (R$)")
        TextField(
            value = resultado,
            onValueChange = { NovoResultado ->
                resultado = NovoResultado
            },
        )
        Spacer(modifier = Modifier.size(12.dp))

        Button(onClick = {
            val vBem:Double = valorBem.toDouble()
            val vM:Double = quantMeses.toDouble()
            val vT:Double = taxaAdm.toDouble()
            val soma = ( vBem / vM ) + ( vBem * vT / vM / 100 )
            resultado = soma.toString()
        },
        modifier = Modifier.fillMaxWidth()
            .padding(40.dp))
        { Text(text = "CALCULAR")}

        Spacer(modifier = Modifier.size(12.dp))



    }






}
@Preview
@Composable
fun AppPreview() {
    CalcularPrestacaoTheme {
        App()
    }
}