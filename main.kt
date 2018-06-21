package swing

import java.awt.*
import java.util.*
import javax.swing.*

fun main(args: Array<String>) {

    val win = Window()

}

class Window: JFrame("Swing test") {

    private val rand = Random()

    private val panel = JPanel()
    init {
        panel.layout = GridLayout(3, 1)
        contentPane.add(panel)
    }

    private val colorPanel = JPanel()
    init {
        colorPanel.layout = GridLayout(3, 2)
        panel.add(colorPanel)
    }

    private var r = 0
    private val rSlider = JSlider()
    private var rLabel = Label()
    init {

        rSlider.minimum = 0
        rSlider.maximum = 255
        rSlider.addChangeListener { rValueChanged() }

        colorPanel.add(rLabel)
        colorPanel.add(rSlider)

    }

    private fun rValueChanged() {
        r = rSlider.value
        rLabel.text = "Red: $r"
        colorChanged()
    }

    private var g = 0
    private val gSlider = JSlider()
    private var gLabel = Label()
    init {

        gSlider.minimum = 0
        gSlider.maximum = 255
        gSlider.addChangeListener { gValueChanged() }

        colorPanel.add(gLabel)
        colorPanel.add(gSlider)

    }

    private fun gValueChanged() {
        g = gSlider.value
        gLabel.text = "Green: $g"
        colorChanged()
    }

    private var b = 0
    private val bSlider = JSlider()
    private var bLabel = Label()
    init {

        bSlider.minimum = 0
        bSlider.maximum = 255
        bSlider.addChangeListener { bValueChanged() }

        colorPanel.add(bLabel)
        colorPanel.add(bSlider)

    }

    private fun bValueChanged() {
        b = bSlider.value
        bLabel.text = "Blue: $b"
        colorChanged()
    }

    private val canvas = Canvas()
    init {

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        canvas.background = Color(r, g, b)
        panel.add(canvas)

        randomColor()

        size = Dimension(600, 400)
        isVisible = true

        println("Init")

    }

    private val button = Button()
    init {
        button.label = "Random Color"
        button.addActionListener { randomColor() }
        panel.add(button)
    }

    private fun randomColor() {

        rSlider.value = rand.nextInt(255)
        gSlider.value = rand.nextInt(255)
        bSlider.value = rand.nextInt(255)

        rValueChanged()
        bValueChanged()
        gValueChanged()

    }

    private fun colorChanged() {
        canvas.background = Color(r, g, b)
    }

}