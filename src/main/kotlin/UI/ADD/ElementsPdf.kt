package UI.ADD

interface Pdfobserver {
    fun update(newpdf : List<String>)
}

class Pdfs()
{
    private val observers = mutableListOf<Pdfobserver>()
    private val items = mutableListOf<String>()


    fun Addpdf(item : String)
    {
        items.add(item)
        notifyObservers()
    }

    fun Removepdf(item : String)
    {
        items.remove(item)
        notifyObservers()
    }

    fun Addobserver(observer : Pdfobserver)
    {
        observers.add(observer)
    }

    fun Removeobserver(observer : Pdfobserver)
    {
        observers.remove(observer)
    }

    private fun notifyObservers()
    {
        for(observer in observers)
        {
            observer.update(items.toList())
        }
    }

}

class ListPdfObserver(private val name : String) : Pdfobserver{
    override fun update(newpdf: List<String>) {
        println("$name: Updated items - $newpdf")
    }

}

fun main()
{

    val subject = Pdfs()
    val observer1 = ListPdfObserver("Observer 1")
    val observer2 = ListPdfObserver("Observer 2")

    subject.Addobserver(observer1)
    subject.Addobserver(observer2)

    subject.Addpdf("Apple")

    subject.Addpdf("Banana")

    subject.Removepdf("Apple")

    subject.Removeobserver(observer1)

    subject.Addpdf("Cherry")
}