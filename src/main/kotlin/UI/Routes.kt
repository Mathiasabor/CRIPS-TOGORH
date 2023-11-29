package UI

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

object Openstate{
    val shouldShowDialog =  mutableStateOf(false)
    var open =mutableStateOf(false)
    val _open : State<Boolean> = open
    var visible =mutableStateOf(false)
    val _visible : State<Boolean> = visible
}

object PersonnelNav
{
    var Navpersonnel =mutableStateOf("")
    val _Navpersonnel : State<String> = Navpersonnel
}

object AjouterNav
{
    var Navajouter =mutableStateOf("")
    val _Navajouter : State<String> = Navajouter
}
object ModifierNav
{
    var Navmodifier =mutableStateOf("")
    val _Navmodifier : State<String> = Navmodifier
}

object Routes{
    var Nav1 =mutableStateOf(0)
    val _Nav1 : State<Int> = Nav1
}

object Routed{
    var Nav2 =mutableStateOf("Tableau de bord")
    val _Nav2 : State<String> = Nav2
}

object Oper{
    var Nav3 =mutableStateOf("")
    val _Nav3 : State<String> = Nav3
}

object Titres{
    var titre =mutableStateOf("")
    val _titre : State<String> = titre
}
data class Org(
    val name : String,val desc : String,val image : String,val nav : String,
)

data class Pers(
    val name : String,val desc : String,val image : String,val nav : Int,
)

object OrgList{
    var orgaList = mutableListOf(
        Org("Administration","admin","ressources-humaines.png","Administration"),
        Org("Comptabilité","admin","salaire.png","Comptabilité"),
        Org("Suivi-Evaluation","admin","ressources-humaines.png","Suivi-Evaluation"),
        Org("Caisse","admin","ressources-humaines.png","Caisse"),
        Org("Assistant Médical","admin","ressources-humaines.png","Assistant Médical"),
        Org("Médecin","admin","ressources-humaines.png","Médecin"),
        Org("Infirmerie","admin","infirmiere.png","Infirmerie"),
        Org("Dispensation/Pharmacie","admin","ressources-humaines.png","Dispensation-Pharmacie"),
        Org("Laboratoire","admin","ressources-humaines.png","Laboratoire"),
        Org("Service Psycho-Social","admin","ressources-humaines.png","Service Psycho-Social"),
        Org("Maternité","admin","ressources-humaines.png","Maternité"),
        Org("Sécurité/Entretien","admin","ressources-humaines.png","Sécurité-Entretien"),


    )
}

/*"Administration"
"Comptabilité"
"Suivi-Evaluation"
"Caisse"
"Assistant Médical"
"Médecin"
"Infirmerie"
"Sécurité-Entretien"*/

object PersList{
    var persList = mutableListOf(
        Pers("AHO KODJO MATHIAS ABOR","admin","homme.png",4),
        Pers("AHO KOKOU PIERRE HIRAM","admin","homme.png",6),
        Pers("AHO KOSSI DZIDULA CASIMIR","admin","homme.png",7),
        Pers("AHO ABLA MAWUSE ANTHONIETTA","admin","femme.png",8),
        Pers("AHO KOMIVI MAWUSI ","admin","homme.png",9),
        Pers("AKATCHY-HEPONOU ABLA HOLALI","admin","femme.png",10),
        Pers("AMEGEE ABLAVI MARIE","admin","femme.png",11),
        Pers("AMEGEE SYLVIA","admin","femme.png",12),


        )
}