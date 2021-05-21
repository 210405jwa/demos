# Cloud Computing

Cloud computing is the usage of computing resources that are in "the cloud", which is really just referring to computing resources managed in a large datacenter or group of datacenters. These are physical locations that contain all of the necessary infrastructure such as power, networking, cooling, and other systems to support computing at scale. Typically, cloud computing works through a "pay-as-you-go" pricing system, which means we pay for the uptime of our computing resources rather than some sort of subscription or upfront cost.

Cloud computing provides simple access to servers, databases, storage, and other services across the internet. Instead of needing to acquire physical hardware and set it up ourselves, we can easily just access paid resources you use over time through a cloud platform such as AWS.

Cloud Computing offers many advantages, such as
1. Variable expense instead of capital expense
    - Instead of paying upfront for computing resources that may not be fully utilized at that moment in anticipation of future demand growth, we can instead only pay for what we need
    - This also helps us to avoid having to worry as much about capacity constraints or idle resources like we would if we needed to buy hardware upfront for deploying our software projects
2. We can benefit from massive economies of scale
    - Cloud computing can often be cheaper than what we could achieve "in-house"
        - Investing in an "in-house" datacenter can be expensive
    - Cloud providers like AWS have the advantage of being able to achieve "economies of scale"
        - By spreading the cost of upfront datacenter investment among many customers,
        they can bring the average cost per customer down
        - They also specialize in efficiency with regards to deploying and maintaining/utilizing their resources
            - Datacenters are their core business, while our business is probably not
3. Speed and Agility
    - New resources can be acquired very easily within minutes
    - If demand suddenly spikes or falls, we could scale our computing resources accordingly
4. Global Deployments
    - We can deploy our application across many different regions in order to provide better latency and experiences for customers

## Models of Cloud Computing
Software infrastructure is composed of the following components:
1. Application
2. Data
3. Runtime Environment
4. Middleware
5. Operating System
6. Virtualization
7. Servers
8. Storage
9. Networking

- Infrastructure as a Service (IaaS)
    - Provides
        - Networking
        - Storage
        - Servers
        - Virtualization
    - Examples:
        - AWS EC2
    - Consumers: System Administrators (and sometimes developers)
- Platform as a Service (PaaS)
    - Provides
        - Networking
        - Storage
        - Servers
        - Virtualization
        - Operating System
        - Middleware
        - Runtime Environments
    - Examples:
        - Azure
        - Heroku
        - AWS Elastic Beanstalk
    - Consumers: Developers
- Software as a Service (SaaS)
    - Provides
        - Everything!
    - Examples:
        - Google Docs
        - Microsoft Office 365
    - Consumers: End Users

# AWS: Amazon Web Services
AWS, or Amazon Web Services, is currently the market leader in cloud computing. There are other vendors such as Microsoft or Google, but Amazon currently occupies the largest market share in cloud computing. In fact, Amazon generates a majority of its profits from AWS, even though AWS makes up approximately 10% of their overall businesses' revenue.

AWS provides many services that are available in the cloud through a "pay-as-you-go" model. This means that customers are only charged for the amount of uptime they are using. There are also "free-tier" resources for new customers for up to a year (in most cases).

Many different resources exist, such as
- EC2: Elastic Compute Cloud
    - Actual computer "instances"
    - Can have different operating systems such as Linux, Windows, Mac
    - For the vast majority of servers on the internet, Linux is used
- RDS: Relational Database Service
    - Database service
    - Provides the ability to get a database up and running very fast
    - We can choose between many different flavors of SQL (MariaDB, Postgres, MySQL, Oracle, MS SQL, etc.)
- EBS: Elastic Block Store
    - Data is stored in "blocks"
        - This is how most data is generally stored on computers (in our hard-drives, SSDs, etc)
    - These are actual isolated SSDs or traditional hard drive disks that can be attached to other services
    - In particular, these EBSes are attached to EC2 instances to provide additional storage
- ELB: Elastic Load Balancing
    - Splits traffic between sources/targets evenly
    - Can be easily configured to route traffic to different EC2 instances
- S3: Simple Storage Service
    - A lot different than EBS
    - Data is stored in "objects"
    - So this is "Object storage"
    - This is where we can store enormous amounts of data cheaply (100s of TBs of data or more)
    - Each "Object", file, whatever you want to store has a maximum size of 5 TB (limited by AWS)
    - Isolated external storage
    - Use cases include data lakes, image storage, etc.
- Route 53
    - Amazon's DNS service
    - We can also register domain names w/ Route 53 and manage other aspects of DNS
- AMI: Amazon Machine Image
    - Images
        - Blueprints for Operating Systems and other software
        - Can be thought of as a snapshot of a system's OS, installed software, and configurations
    - AMIs are different images available to utilize for EC2 instances
        - It is possible to create our own AMIs based on the current state of our own EC2s
            - Really useful in the case that we want to scale up by taking this AMI image w/ our application and other configurations and starting up new EC2 instances w/ that custom AMI
- IAM: Identity Access Management
    - Role-based permissions/security service
    - Can configure different roles and different permissions for each role
    - Usually we shouldn't be using the root user to login to the AWS console, and instead create another user through IAM to do so
- SG: Security Groups
    - Allows us to create a list of rules on what traffic should be allowed
    - What IPs can connect to our RDS or EC2, and on what ports? (Inbound connections)
    - What IPs can our RDS or EC2 respond to? (Outbound connections)
- Auto-scaling
    - Useful when needing to scale the amount of resources based on user load
    - Can be very useful in industry
    - But on a personal level, we could accidentally accrue large costs
    - Types of Scaling:
        - Vertical Scaling: Increases the power of an instance
            - Adding more RAM
            - Upgrading the CPU
            - Adding more storage
        - Horizontal Scaling: Increasing the number of instances

Vertical scaling was often the traditional approach since provisioning more servers and designing the architecture to support users across multiple servers was often a lot of work and more difficult. Horizontal scaling would require additional configuration, server rackspace, power, cooling, etc, but with the advent of cloud computing, horizontal scaling has become more of the norm.

Cloud computing providers have been able to push the leading edge of dynamically creating virtual machines and spreading these machines efficiently on the physical host systems/machines such that these providers can maximize utilization of their computing resources. This makes it easier to have horizontal scaling through fast provision of new resources and fast deprovisioning of existing resources.

At a certain point, vertical scaling becomes too expensive, because of diminishing returns of increases in computing power v. increases in price. Trying to scale a single instance up to more powerful specs is inefficient in terms of cost v. performance. Instead, with horizontal scaling, we can have many weaker systems that ultimately add up to being much more cost effective in terms of cost to total computing power.

As consumer demand increased for online services, horizontal scaling was ultimately what helped to meet the challenges of serving all of those customers. This is especially true for companies such as Netflix, Google, Amazon, etc. that became extremely popular in an unprecedented amount of time. The expectation of consumers for reliability of these services has set the norm, which has led to the same expectations for everyone providing online services. Cloud computing has provided the capability for smaller business to adapt to the challenges of growth and scalability as well. Moving forward, cloud computing will continue to grow exponentially and provide a lot of opportunities for those who know how to use it and can become experts at understanding and utilizing all of the different cloud service offerings available.