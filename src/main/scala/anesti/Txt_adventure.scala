package anesti

import indigo._
import indigo.platform.assets.DynamicText
import indigo.scenes._
import indigo.shared.AnimationsRegister
import indigo.shared.FontRegister

import scala.scalajs.js.annotation.JSExportTopLevel

val boundaryLocator = new BoundaryLocator(new AnimationsRegister, new FontRegister, new DynamicText)
val context = new FrameContext[Unit](GameTime.zero, Dice.fromSeed(1l), InputState.default, boundaryLocator, ())





@JSExportTopLevel("IndigoGame")
object Txt_adventure extends IndigoGame[Unit, Unit, Unit, Unit]:

  val assetName = AssetName("dots")

  val fontKey:FontKey = FontKey("font")
  //(character: String, x: Int, y: Int, width: Int, height: Int):
  val fontInfo:FontInfo =
    FontInfo(fontKey, 117, 102, FontChar("?", 27, 85, 8, 16))
      .addChar(FontChar("A", 0, 0, 8, 16))
      .addChar(FontChar("B", 9, 34, 8, 16))
      

  val assets: Set[AssetType] = 
    Set(
    AssetType.Image(AssetName("dots"), AssetPath(s"assets/dots.png")),
    AssetType.Image(AssetName("font"), AssetPath(s"assets/font.png"))
  )
  
  def initialScene(bootData: Unit): Option[SceneName] =
    None

  def scenes(bootData: Unit): NonEmptyList[Scene[Unit, Unit, Unit]] =
    NonEmptyList(GameScene)

  val eventFilters: EventFilters =
    EventFilters.Permissive

  val config = GameConfig.default
          .withViewport(640, 400)
      

  def boot(flags: Map[String, String]): Outcome[BootResult[Unit]] =
    Outcome(
      BootResult.noData(
        config
      ).withAssets(assets).withFonts(fontInfo)
    )

  def initialModel(startupData: Unit): Outcome[Unit] =
    Outcome(())

  def initialViewModel(startupData: Unit, model: Unit): Outcome[Unit] =
    Outcome(())

  def setup(
      bootData: Unit,
      assetCollection: AssetCollection,
      dice: Dice
  ): Outcome[Startup[Unit]] =
    Outcome(Startup.Success(()).addFonts(fontInfo))

  def updateModel(
      context: FrameContext[Unit],
      model: Unit
  ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(model)

  def updateViewModel(
      context: FrameContext[Unit],
      model: Unit,
      viewModel: Unit
  ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(viewModel)

  val graphic = Graphic(Rectangle(0, 0, 32, 32), 1, Material.Bitmap(assetName))


  def present(
      context: FrameContext[Unit],
      model: Unit,
      viewModel: Unit
  ): Outcome[SceneUpdateFragment] =
    Outcome(
    // SceneUpdateFragment.empty
    SceneUpdateFragment(
        ///(text: String, x: Int, y: Int, depth: Int, fontKey: FontKey, material: M): Text[M] =
        Text("ABABABAB????", 0,0,1, fontKey, Material.Bitmap(AssetName("font"))).alignRight,
        // graphic.moveBy(10,0),    
        // Graphic(Rectangle(0, 0, 32, 32), 1, Material.Bitmap(assetName)),
        Graphic(Rectangle(0, 20, 100, 100), 1, Material.Bitmap(AssetName("font"))),
        // Graphic(Rectangle(0, 0, 32, 32), 1, Material.Bitmap(assetName))
        //   .withCrop(Rectangle(16, 16, 16, 16))
        //   .withRef(8, 8)
        //   .moveTo(
        //     Signal
        //       .Orbit(config.viewport.giveDimensions(1).center, 30)
        //       .map(_.toPoint)
        //       .at(context.running)
        //   )      
        // TextBox("Hello, World!", 200, 30)
        //   .withFontFamily(FontFamily.cursive)
        //   .withColor(RGBA.White)
        //   .withFontSize(Pixels(16))
        //   .withStroke(TextStroke(RGBA.Red, Pixels(1)))
        //   .italic
        //   .alignRight     
        )
    )
