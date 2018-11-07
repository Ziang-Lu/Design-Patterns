1. Start the name server

   ```bash
   > pyro4-ns --port 5000
   Not starting broadcast server for localhost.
   NS running on localhost:5000 (127.0.0.1)
   URI = PYRO:Pyro.NameServer@localhost:5000
   ```

   List all the registered objects in the name server

   ```bash
   > pyro4-nsc list --port 5000
   --------START LIST
   Pyro.NameServer --> PYRO:Pyro.NameServer@localhost:5000
       metadata: ['class:Pyro4.naming.NameServer']
   --------END LIST
   ```

2. Server-side

   ```bash
   python3 remote_company.py
   ```

   List all the registered objects in the name server

   ```bash
   > pyro4-nsc list --port 5000
   --------START LIST
   Pyro.NameServer --> PYRO:Pyro.NameServer@localhost:5000
       metadata: ['class:Pyro4.naming.NameServer']
   report_generator --> PYRO:obj_31050e224ba34ef28a1227c5ad77fb69@localhost:55017
   --------END LIST
   ```

3. Client-side

   ```bash
   python3 local_company_owner.py --ns_port 5000 --name report_generator
   ```

