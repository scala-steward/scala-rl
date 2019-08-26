/**
  * Graph modeling?
  *
  *
  * Notes:
  * - Functional graph: https://manuel.kiessling.net/2016/02/15/scala-traversing-a-graph-in-a-functional-way/
  * - scala-graph
  * verizon's quiver library
  */
package io.samritchie.rl

/**
  * There is some set of possible places you can get from a given
  * state. Do we know that in advance?
  */
case class Graph[A <: Action, Reward](actions: Set[State[A, Reward]])
