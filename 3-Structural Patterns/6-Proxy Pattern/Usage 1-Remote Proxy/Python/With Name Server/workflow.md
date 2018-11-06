1. Start the <u>name server</u>   [Java RMI registry]

   ```bash
   > pyro4-ns --port 5000
   Not starting broadcast server for localhost.
   NS running on localhost:5000 (127.0.0.1)
   URI = PYRO:Pyro.NameServer@localhost:5000
   ```

2. List all the registered objects in the name server

   ```bash
   > pyro4-nsc list
   --------START LIST
   Pyro.NameServer --> PYRO:Pyro.NameServer@localhost:5000
       metadata: ['class:Pyro4.naming.NameServer']
   --------END LIST
   ```

3. Svsvsvs

