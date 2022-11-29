
## Infraestructure diagram
![Alt text](Infraestructure.png?raw=true "Infraestructure diagram")

## Notes
__Create a ssh key__  
`ssh-keygen -f mykey`  

__Connect to ec2 via ssh__  
`ssh 3.84.92.132 -l ubuntu -i ~/Documents/ssh/mykey`

__Install httpd-apache2__  
`sudo apt-get update  
sudo apt install apache2 -y`  

__Install node__  
`npm install`  

__Run node app__  
`node app.js`  

__Ports in use__  
`netstat -tnlp`  

## References
[How to Create Custom EC2 VPCs in AWS Using Terraform](https://www.ahead.com/resources/how-to-create-custom-ec2-vpcs-in-aws-using-terraform/)  
[Provisioning a Network Load Balancer with Terraform](https://hceris.com/provisioning-a-network-load-balancer-with-terraform/)  
[AWS VPC Beginner to Pro - Virtual Private Cloud Tutorial](https://www.youtube.com/watch?v=g2JOHLHh4rI)  
[How to Get your Default Profile with AWS CLI](https://bobbyhadz.com/blog/aws-cli-get-default-profile)  
[Amazon EC2 AMI Locator](https://cloud-images.ubuntu.com/locator/ec2/)  
[How to Install Apache 2 on AWS EC2 Instance Ubuntu 20.04](https://cloudkatha.com/how-to-install-apache-2-on-aws-ec2-instance-ubuntu-20-04/)  
[Deploying a Nodejs app using Ansible](https://www.linkedin.com/pulse/deploying-nodejs-app-using-ansible-antoine-choula-/)  
[How to Clone a Git Repository with Ansible](https://linuxhandbook.com/clone-git-ansible/)  
[Configuring Apache for Node.js](https://blog.logrocket.com/configuring-apache-for-node-js/)  
[Tutorial: Setting Up Node.js on an Amazon EC2 Instance](https://docs.aws.amazon.com/sdk-for-javascript/v2/developer-guide/setting-up-node-on-ec2-instance.html)  
[Deploying a Node.js app using Ansible](https://medium.com/nonstopio/deploying-a-node-js-app-using-ansible-cfe7dfeddcac)  
[Installing Apache on Ansible](https://www.scaleway.com/en/docs/tutorials/install-apache-ansible/)  
[Learn DevOps: Infrastructure Automation With Terraform](https://www.udemy.com/course/learn-devops-infrastructure-automation-with-terraform/)
