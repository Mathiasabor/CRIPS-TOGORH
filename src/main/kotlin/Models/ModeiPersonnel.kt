package Models

data class Personnel(
    var infoPerso: InfoPerso,
    var infoPro: InfoPro?,
    var confidentielles: Confidentielles?,
    var competence: Competence?
)

data class InfoPerso(
    var Nom : String,
    var Prenom : String,
    var Sexe : String,
    var Nationaite : String,
    var Telephone : String,
    var Email : String,
    var Adresse : String,
    var Ville : String,
    var Image : String

)

data class InfoPro(
    var Fonction : String,
    var CV : Boolean,
    var Motivation : Boolean,
    var Nssocial : Int,
    var Casierju : String,
    var Casi : Boolean,
)

data class Competence(
    var diplome : String,
    var dip : Boolean
)

data class Confidentielles(
    var CarteIdentite : Boolean,
    var CertificatNationalite : Boolean,
    var ActeDeNaissance : Boolean,
    var CertificatMedical : Boolean,
    var Enfants : Int,
    var ActeDeNaissanceEnfant: Boolean,
    var CertificatDeVieEnfant : Boolean
)

data class Absence(
    var FicheConge : Boolean,
    var OrdreMission : Boolean,
    var AttestationMedicale : Boolean,
    var AccidentTravail : Boolean,
    var ArretMaladie : Boolean
)

data class Evalutation(
    var Eval : Boolean?
)

data class Salaire(
    var Salaire : String?,
    var FicheDePaie : String?
)

data class Departement(
    var name : String,
    var size : Int
)