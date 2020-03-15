package com.moqi.groovy.a05

class A0510ComplexNumber {
   def real, imaginary

    A0510ComplexNumber(real, imaginary) {
    this.real = real
    this.imaginary = imaginary
  }

  def plus(rhs) {
    new A0510ComplexNumber(this.real + rhs.real, this.imaginary + rhs.imaginary)
  }
  // formula: (x + yi)(u + vi) = (xu – yv) + (xv + yu)i.
  def multiply(rhs) {
    new A0510ComplexNumber(
        real * rhs.real - imaginary * rhs.imaginary,
        real * rhs.imaginary + imaginary * rhs.real)
  }

  def String toString() {
    real.toString() + ((imaginary < 0 ? "" : "+") + imaginary + "i").toString()
  }
}