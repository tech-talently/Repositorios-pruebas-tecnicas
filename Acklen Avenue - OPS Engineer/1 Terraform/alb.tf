resource "aws_alb" "my-alb"{
  name = "my-alb"
  subnets = [aws_subnet.main-public-1.id, aws_subnet.main-public-2.id]
  security_groups = [aws_security_group.alb-securitygroup.id]
}

resource "aws_alb_target_group" "frontend-target-group"{
  name = "frontend-target-group"
  port = 80
  protocol = "HTTP"
  vpc_id = "${aws_vpc.main.id}"
}

resource "aws_alb_target_group_attachment" "frontend-attachment-1"{
  target_group_arn = "${aws_alb_target_group.frontend-target-group.arn}"
  target_id = "${aws_instance.vm_1.id}"
  port = 80 
}

resource "aws_alb_target_group_attachment" "frontend-attachment-2"{
  target_group_arn = "${aws_alb_target_group.frontend-target-group.arn}"
  target_id = "${aws_instance.vm_2.id}"
  port = 80 
}

resource "aws_alb_listener" "frontend-listeners" { 
  load_balancer_arn = "${aws_alb.my-alb.arn}"
  port = 80

  default_action {
    target_group_arn = "${aws_alb_target_group.frontend-target-group.arn}"
    type = "forward"
  }
}