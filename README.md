
# AWS CodePipeline with Github + AWS CodeBuild + AWS CloudFormation  
  
### 1. Create a CloudFormation Role  
  
* Trusted entity: AWS CloudFormation  
* Permissions: AWSLambdaExecute  
* Add AmazonS3FullAccess policy  
* Add inline policy:  
  
```json  
        {  
            "Statement": [  
                {  
                    "Action": [  
                        "apigateway:*",  
                        "codedeploy:*",  
                        "lambda:*",  
                        "cloudformation:CreateChangeSet",  
                        "iam:GetRole",  
                        "iam:CreateRole",  
                        "iam:DeleteRole",  
                        "iam:PutRolePolicy",  
                        "iam:AttachRolePolicy",  
                        "iam:DeleteRolePolicy",  
                        "iam:DetachRolePolicy",  
                        "iam:PassRole",  
                        "s3:GetObjectVersion",  
                        "s3:GetBucketVersioning"  
                    ],  
                    "Resource": "*",  
                    "Effect": "Allow"  
                }  
            ],  
            "Version": "2012-10-17"  
        }  
```   
  
###	2. Create a AWS CodePipeline  
 
 * Source provider: Github  
	- Connect github repository  
	- Select repository and branch  
  
* Build provider: AWS CodeBuild  
	 * Create a new code build project  
  
* Deploy provider: AWS CloudFormation  
	* Action mode – Create or replace a change set  
	* Stack name – lambda-pipeline-stack  
	* Change set name – lambda-pipeline-changeset  
	* Template – BuildArtifact::outputtemplate.yaml  
	* Capabilities – CAPABILITY_IAM  
	* Role name – created cloud formation role name here  
  
- Edit CodePipeline  
- Add action group  
	* Action name – execute-changeset  
	* Deploy provider – AWS CloudFormation  
	* Input artifacts – BuildArtifact  
	* Action mode – Execute a change set  
	* Stack name – lambda-pipeline-stack  
	* Change set name – lambda-pipeline-changeset  
  
### Sources:  
* https://docs.aws.amazon.com/lambda/latest/dg/build-pipeline.html