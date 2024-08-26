//
//  LoginView.swift
//  iosApp
//
//  Created by Denis Selivanov on 8/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginView: View {
    
    let viewModel: LoginViewModel = LoginViewModel()
    
    @KMPState var login: Binding<String>
    @KMPState var password: Binding<String>
    @KMPState var isLoading: Bool
    
    init() {
        self._login = KMPState(stateFlow: viewModel.login, default: .constant(""))
        self._password = KMPState(stateFlow: viewModel.password, default: .constant(""))
        self._isLoading = KMPState(stateFlow: viewModel.isLoading, default: false)
    }
    
    var body: some View {
        VStack {
            TextField("Login", text: login)
            TextField("Password", text: password)
            
            ZStack {
                Button("Login") {
                    viewModel.loginClicked()
                }
                if isLoading {
                    HStack {
                        Spacer()
                        ProgressView()
                    }
                }
            }
            .frame(maxWidth: .infinity)
        }
    }
}

#Preview {
    LoginView()
}
