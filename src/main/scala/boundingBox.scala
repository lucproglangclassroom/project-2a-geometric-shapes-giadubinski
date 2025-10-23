package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))

    case Ellipse(rx, ry) =>
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

    case Location(x, y, shape) =>
      val Location(u, v, Rectangle(w, h)) = apply(shape)
      Location(u + x, v + y, Rectangle(w, h))

    case Group() =>
      Location(0, 0, Rectangle(0, 0))

    case Group(shapes @ _*) =>
      val boxes = shapes.map(apply)
      val quads = boxes.map:
        case Location(u, v, Rectangle(w, h)) => (u, v, u + w, v + h)

      val minX = quads.map(_._1).min
      val minY = quads.map(_._2).min
      val maxX = quads.map(_._3).max
      val maxY = quads.map(_._4).max

      Location(minX, minY, Rectangle(maxX - minX, maxY - minY))

end boundingBox
