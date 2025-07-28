import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Cache Capacity:");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Cache<Integer, String> cache = new LRUCache<>(capacity);
        System.out.println("\nCache initialized with capacity " + capacity + ".");
        System.out.println("Available commands:");
        System.out.println("put <key> <value>");
        System.out.println("get <key>");
        System.out.println("delete <key>");
        System.out.println("exit\n");

        while (true)
        {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split("\\s+");

            if(parts.length == 0)
            continue;

            String command = parts[0].toLowerCase();

            try
            {
                switch (command)
                {
                    case "put":
                    {   
                        if(parts.length != 3)
                        {
                            System.out.println("Usage: put <key> <value>");
                            break;
                        }
                        int putKey = Integer.parseInt(parts[1]);
                        String value = parts[2];
                        cache.put(putKey, value);
                        System.out.println("Put (" + putKey + ", " + value + ")");
                        break;
                    }

                    case "get":
                    {
                        if (parts.length != 2)
                        {
                            System.out.println("Usage: get <key>");
                            break;
                        }

                        int getKey = Integer.parseInt(parts[1]);
                        String result = cache.get(getKey);

                        if(result == null)
                        System.out.println("Key not found.");

                        else
                        System.out.println("Value: " + result);

                        break;
                    }

                    case "delete":
                    {
                        if(parts.length != 2)
                        {
                            System.out.println("Usage: delete <key>");
                            break;
                        }

                        int delKey = Integer.parseInt(parts[1]);
                        cache.delete(delKey);
                        System.out.println("Deleted key: " + delKey);
                        break;
                    }

                    case "exit":
                    {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }

                    default:
                    System.out.println("Unknown command.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid key. Please enter an integer.");
            }
        }
    }
}
