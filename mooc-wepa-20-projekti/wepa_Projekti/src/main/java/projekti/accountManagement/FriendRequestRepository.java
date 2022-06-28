/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.accountManagement;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kimmo
 */
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long>{
    FriendRequest findByReceiverAndSender(String receiver, String sender);
}
