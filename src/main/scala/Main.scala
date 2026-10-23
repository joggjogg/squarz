import gamelib.*
import java.awt.Graphics2D
import scala.jdk.CollectionConverters.*

class Circle extends Drawable:
    override def draw(g: Graphics2D): Unit =
        g.fillOval(
          Game.cellWidth*3,   // x coordinaat (derde kolom)
          Game.cellHeight*4,  // y coordinaat (vierde rij)
          Game.cellWidth,     // breedte 
          Game.cellHeight     // hoogte
        )

object Game:
  val windowWidth: Int = 800
  val windowHeight: Int = 800
  val numRows: Int = 10
  val numColumns: Int = 10
  val cellWidth: Int = windowWidth/numColumns
  val cellHeight: Int = windowHeight/numRows

  def main(args: Array[String]): Unit =
    // BELANGRIJK: onderstaande code is slechts ter illustratie
    // we verwachten dat je de code aanpast en uitbreidt.

    // maak een instantie van de GUI aan
    val gui = new GUI(windowWidth, windowHeight, numRows, numColumns, 0)
    // krijg toegang tot het grid om dingen te tekenen
    val panel = gui.getGridPanel()
    // maak cellen aan die in het grid moeten worden toegevoegd
    val mycircle = new Circle()
    val drawablesToAdd: List[Drawable] = List(mycircle)
    // voeg ze toe aan het grid 
    panel.addDrawables(drawablesToAdd.asJava)

    // de onderstaande code voegt een "press listener"
    // toe aan het grid. Dit zorgt ervoor dat wanneer
    // de speler klikt in het venster dat de meegegeven
    // functie wordt aangeroepen met het x- en y-coordinaat
    // van waar de gebruiker geklikt heeft. 
    def onClick(x: Int, y: Int): Unit = 
      // als de gebruiker op de spelstuk heeft geklikt
      // dan verwijderen we hem 
      if    x > cellWidth*3  && x <= cellWidth*4 
         && y > cellHeight*4 && y <= cellHeight*5 
      then panel.removeDrawable(mycircle)

    panel.setPressListener(onClick)     
