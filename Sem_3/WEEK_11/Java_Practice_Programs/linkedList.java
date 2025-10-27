import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) {
        val = v;
    }
}

public class PlaylistManager {
    
    public String runPlaylist(List<String> commands) {
        ListNode head = null;
        ListNode tail = null;
        String result = "";
        
        for (String command : commands) {
            String[] parts = command.split(" ");
            String cmd = parts[0];
            
            switch (cmd) {
                case "ADD_END":
                    int x = Integer.parseInt(parts[1]);
                    ListNode newNode = new ListNode(x);
                    if (head == null) {
                        head = newNode;
                        tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                    break;
                    
                case "ADD_AFTER":
                    int a = Integer.parseInt(parts[1]);
                    int b = Integer.parseInt(parts[2]);
                    ListNode curr = head;
                    while (curr != null) {
                        if (curr.val == a) {
                            ListNode insertNode = new ListNode(b);
                            insertNode.next = curr.next;
                            curr.next = insertNode;
                            if (curr == tail) {
                                tail = insertNode;
                            }
                            break;
                        }
                        curr = curr.next;
                    }
                    break;
                    
                case "DELETE":
                    int delVal = Integer.parseInt(parts[1]);
                    if (head == null) break;
                    
                    if (head.val == delVal) {
                        head = head.next;
                        if (head == null) {
                            tail = null;
                        }
                    } else {
                        ListNode prev = head;
                        while (prev.next != null) {
                            if (prev.next.val == delVal) {
                                if (prev.next == tail) {
                                    tail = prev;
                                }
                                prev.next = prev.next.next;
                                break;
                            }
                            prev = prev.next;
                        }
                    }
                    break;
                    
                case "REVERSE_K":
                    int k = Integer.parseInt(parts[1]);
                    head = reverseKGroup(head, k);
                    // Update tail
                    tail = head;
                    if (tail != null) {
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                    }
                    break;
                    
                case "DEDUP":
                    head = dedup(head);
                    // Update tail
                    tail = head;
                    if (tail != null) {
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                    }
                    break;
                    
                case "PRINT":
                    result = printList(head);
                    break;
            }
        }
        
        // If PRINT was never called, return final playlist
        if (result.isEmpty() && head != null) {
            result = printList(head);
        }
        
        return result;
    }
    
    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        // Count total nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        
        while (count >= k) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            ListNode prev = null;
            ListNode next = null;
            
            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            // Connect with previous group
            prevGroupEnd.next = prev;
            groupStart.next = curr;
            prevGroupEnd = groupStart;
            
            count -= k;
        }
        
        return dummy.next;
    }
    
    private ListNode dedup(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        
        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
        
        return head;
    }
    
    private String printList(ListNode head) {
        if (head == null) return "";
        
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) {
                sb.append(" ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        PlaylistManager pm = new PlaylistManager();
        
        List<String> commands = Arrays.asList(
            "ADD_END 10",
            "ADD_END 20",
            "ADD_AFTER 10 15",
            "ADD_END 10",
            "DEDUP",
            "REVERSE_K 2",
            "PRINT"
        );
        
        String result = pm.runPlaylist(commands);
        System.out.println(result);
    }
}
