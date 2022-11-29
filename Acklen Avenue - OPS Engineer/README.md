# Acklen Avenue - DevOps Challenge  
#### Challenge Instructions - Devops-Challenge.pdf  
#### Prerequisites  
* Terraform
* Ansible
* AWS Console account  
* IAM Admin User  
* SSH Key

#### To run  
1. Edit `~/1 Terraform/vars.tf` file adding the values for 
  - AWS_ACCESS_KEY
  - AWS_SECRET_KEY
  - PATH_TO_PRIVATE_KEY
  - PATH_TO_PUBLIC_KEY
2. Using a terminal
3. Located into `~/1 Terraform/` folder, run:  
`terraform init`  
`terraform apply`
4. Once the infraestructure is ready, edit the `~/2 Ansible/inventory.txt` file, adding the IP adress of the EC2 instances just created and adding the path to your ssh-key.
5. Located into `~/2 Ansible/` folder, run:  
`ansible-playbook playbook.yml -i inventory.txt`  
6. The deploy is ready, open in a browser the load balancer url :blush:
