variable "aws_bucket_name" {}
variable "aws_bucket_key" {}

variable "project_name" {}
variable "region" {}
variable "env" {}

variable "certificate_arn" {}

variable "ec2_name" {
  type        = string
  description = "POO IFSP Api"
  default     = ""
}

variable "ingress_allowed_cidrs_prod" {
  default     = ["10.0.0.0/16"]
  description = "List of allowed cidrs ranges"
}

variable "lb_ingress_ports" {
  default     = ["443", "80"]
  description = "List of allowed ports"
}