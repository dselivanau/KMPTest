//
// Copyright (c) New Cloud Technologies, Ltd., 2019-2024
//
// You can not use the contents of the file in any way without New Cloud Technologies, Ltd. written permission.
// To obtain such a permit, you should contact New Cloud Technologies, Ltd. at https://myoffice.ru/contacts/
//

import SwiftUI
import shared

@propertyWrapper
public struct KMPState<MappedType>: DynamicProperty {
    @ObservedObject private var box: KMPStateObservable<AnyObject, MappedType>

    public var wrappedValue: MappedType {
        get {
            box.value
        }
        nonmutating set {
            box.value = newValue
        }
    }

    public init(stateFlow: StateFlow, default: MappedType) {
        self._box = .init(wrappedValue: KMPStateObservable<AnyObject, MappedType>(stateFlow) { $0 as? MappedType ?? `default` })
    }

    public init(stateFlow: StateFlow, mapping: @escaping (AnyObject?) -> MappedType) {
        self._box = .init(wrappedValue: KMPStateObservable<AnyObject, MappedType>(stateFlow, mapping: mapping))
    }
}
