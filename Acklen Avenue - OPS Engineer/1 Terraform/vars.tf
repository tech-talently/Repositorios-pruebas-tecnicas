variable "AWS_ACCESS_KEY" {
  default = "AWS_ACCESS_KEY"
}

variable "AWS_SECRET_KEY" {
  default = "AWS_SECRET_KEY"
}

variable "AWS_REGION" {
  default = "us-east-1"
}

variable "PATH_TO_PRIVATE_KEY" {
  default = "[UPDATE ~/Documents/ssh/mykey]"
}

variable "PATH_TO_PUBLIC_KEY" {
  default = "[UPDATE ~/Documents/ssh/mykey.pub]"
}

variable "AMIS" {
  type = map(string)
  default = {
    us-east-1 = "ami-0b0ea68c435eb488d"
  }
}

