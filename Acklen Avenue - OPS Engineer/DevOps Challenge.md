DevOps Challenge

For this project challenge you will need to fork this project: https://github.com/abkunal/Chat-App-using-Socket.io

Your objective for this is to deploy this project to a cloud provider..
Prerequisites:
NodeJs
Ansible
Terraform
Github

Which cloud provider?
In Acklen Avenue we work with AWS. So we will prefer that you can deploy it in AWS. But if you know Azure, GCP or another cloud provider, feel free to work with that specific technology.
E.g
In AWS we use EC2 in Azure the equivalent is Azure Virtual Machine.

All of this work has to be  saved in Github Repository.
You will need to commit all of your work in your repository. When you finished, shared your Github repository to the recruiting email. 

Step 1
Prepare the networking. With Terraform, you will do this.
Create a VPC with 2 public subnets in two different availability zones. If this is new to you, take some time to search for this, as you will need to understand this to continue with the challenge.

Step #2
You will need to create 2 EC2 instances and assign them in the VPC created in Step 1.
For doing this you will need to use terraform

-----
Challenge
In case you want to show you rock with Terraform, instead of using EC2, create an autoscaling group. So we can have dynamic instances.

Step #3
You will need to create an application load balancer for this. The idea is that for accessing the application it has to be using the load balancer. For doing this you will need to use terraform

Step #4
When you have the infrastructure, you will need to install the application. You will need to install node in the EC2 you created in step 2 and configure the application. Remember the application will need to be up always. For doing this, you will need to run ansible for configuring everything. 

Step #5
Create a README file and place all the steps. The way we’re going to evaluate this, is following the instructions from this file. So be clear as possible. Explain which are the variables, etc
